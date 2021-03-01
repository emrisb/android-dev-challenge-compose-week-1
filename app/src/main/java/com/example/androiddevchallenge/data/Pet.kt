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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

data class Pet(
    val id: Int,
    val name: String,
    val age: Int,
    val sex: String,
    val description: String,
    val photo: Int,
)

val petList = listOf(
    Pet(
        1,
        "İstanbul",
        2,
        "Male",
        "The Cavapoo is a mixed breed dog — a cross between the Cavalier King Charles Spaniel and Poodle dog breeds. Outgoing, playful, and curious, these pups inherit some of the best traits from both of their parents.",
        R.drawable.istanbul
    ),
    Pet(
        2,
        "New York",
        4,
        "Female",
        "Boxer dogs were originally bred to be medium-size guard dogs. Today, although they are a part of the AKC’s Working Group, Boxers mostly find homes as loving family companions. That said, they still retain their high energy levels and need plenty of exercise.",
        R.drawable.new_york
    ),
    Pet(
        3,
        "Berlin",
        1,
        "Male",
        "The Afador is a mixed breed dog–a cross between the Afghan Hound and Labrador Retriever dog breeds. Loyal, energetic, and affectionate, these pups inherited some of the best qualities from both of their parents.",
        R.drawable.berlin
    ),
    Pet(
        4,
        "Amsterdam",
        3,
        "Male",
        "The Akita is a large and powerful dog breed with a noble and intimidating presence. They were originally used for guarding royalty and nobility in feudal Japan. These dogs also tracked and hunted wild boar, black bear, and sometimes deer.",
        R.drawable.amsterdam
    ),
    Pet(
        5,
        "California",
        1,
        "Female",
        "Known as the “King of Terriers,” the Airedale is indeed the largest of all terriers. The dog breed originated in the Aire Valley of Yorkshire and was created to catch otters and rats in the region between the Aire and Wharfe Rivers. An able sporting dog, they became an ideal working dog as well, proving their worth during World War I.",
        R.drawable.california
    ),
    Pet(
        6,
        "Tokyo",
        5,
        "Male",
        "The Australian Shepherd Lab Mix is a mixed breed dog — a cross between the Australian Shepherd and the Labrador Retriever dog breeds. Medium in size, energetic, and loyal, these pups inherited some amazing traits from both of their parents.",
        R.drawable.tokyo
    ),
    Pet(
        7,
        "Rio",
        2,
        "Male",
        "A dog breed named for the Azawakh Valley in the Sahara desert where they originated, this is a lean and swift hunter with a regal presence. They’re proud but loyal and protective of their home and family.",
        R.drawable.rio
    ),
    Pet(
        8,
        "Lisbon",
        3,
        "Female",
        "The Basset Retriever is a mixed breed dog–a cross between the Basset Hound and Golden Retriever dog breeds. Friendly, affectionate, and intelligent, these pups inherited some of the best qualities from both of their parents.",
        R.drawable.lisbon
    ),
    Pet(
        9,
        "Helsinki",
        4,
        "Male",
        "The Bocker is a mixed breed dog — a cross between the Cocker Spaniel and Beagle dog breeds. Small, affectionate, and curious by nature, these pups inherited some of the best qualities from both of their parents.",
        R.drawable.helsinki
    ),
    Pet(
        10,
        "Nairobi",
        5,
        "Female",
        "The Borzoi dog breed was developed in Russia as a coursing and hunting dog. These hounds hunted in teams of three to go after rabbit, foxes, and wolves. They later became popular as a companion for royalty across continental Europe.",
        R.drawable.nairobi
    ),
)
