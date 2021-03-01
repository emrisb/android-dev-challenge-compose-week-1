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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

class PetDetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                getPetItem()?.let {
                    PetDetail(it)
                }
            }
        }
    }

    private fun getPetItem(): Pet? {
        val petId = intent.getIntExtra(PET_ID, -1)
        return if (petId != -1) {
            petList.firstOrNull { it.id == petId }
        } else null
    }

    companion object {
        private const val PET_ID = "pet_id"

        fun newIntent(context: Context, petId: Int) =
            Intent(context, PetDetailScreen::class.java).apply {
                putExtra(PET_ID, petId)
            }
    }
}

@Composable
fun PetDetail(pet: Pet) {
    val context = LocalContext.current
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Image(
                painter = painterResource(id = pet.photo),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = pet.name,
                    style = typography.h6
                )

                Text(
                    text = pet.sex,
                    style = typography.body2
                )

                Text(
                    text = "${pet.age} years",
                    style = typography.body2
                )

                Text(
                    text = pet.description,
                    style = typography.body1,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Button(
                onClick = {
                    Toast.makeText(context, "Thank You", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Adopt Me")
            }
        }
    }
}

@Preview("Light Theme1", widthDp = 360, heightDp = 640)
@Composable
fun PetDetailLightPreview() {
    MyTheme {
        PetDetail(petList[1])
    }
}

@Preview("Dark Theme1", widthDp = 360, heightDp = 640)
@Composable
fun PetDetailDarkPreview() {
    MyTheme(darkTheme = true) {
        PetDetail(petList[1])
    }
}
