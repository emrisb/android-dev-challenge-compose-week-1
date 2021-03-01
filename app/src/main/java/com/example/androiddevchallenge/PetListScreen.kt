/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.petList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class PetListScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                PetList(petList)
            }
        }
    }
}

@Composable
fun PetList(petList: List<Pet>) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {

            item {
                Header()
            }

            items(items = petList) { pet ->
                PetItem(pet = pet)
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(40.dp)
    ) {
        Image(
            modifier = Modifier
                .height(40.dp),
            alignment = Alignment.CenterStart,
            contentDescription = null,
            painter = painterResource(R.drawable.dog),
        )

        Text(
            text = "Petty",
            modifier = Modifier
                .padding(start = 16.dp),
            style = typography.h6
        )
    }
}

@Composable
fun PetItem(pet: Pet) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    context.startActivity(PetDetailScreen.newIntent(context, pet.id))
                }
            )
    ) {
        Column {
            Image(
                painter = painterResource(id = pet.photo),
                contentDescription = pet.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = pet.name,
                    style = typography.h6,
                )
                Text(
                    text = " • ${pet.age} years",
                    style = typography.h6,
                )
                Text(
                    text = " • ${pet.sex}",
                    style = typography.h6,
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PetListLightPreview() {
    MyTheme {
        PetList(petList)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PetListDarkPreview() {
    MyTheme(darkTheme = true) {
        PetList(petList)
    }
}
