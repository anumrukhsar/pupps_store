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
package com.example.androiddevchallenge.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.enums.Gender
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        initPuppyListing()
    }
}


@Composable
fun initPuppyListing() {
    val context = LocalContext.current
    var puppyList = listOf(
        Puppy(
            stringResource(R.string.bella), Gender.FEMALE.value,
            stringResource(R.string.bella_desc), R.drawable.dog_one,
        ),
        Puppy(
            stringResource(R.string.lucy),
            Gender.FEMALE.value,
            stringResource(R.string.lucy_desc),
            R.drawable.dog_two
        ),
        Puppy(
            stringResource(R.string.daisy),
            Gender.FEMALE.value,
            stringResource(R.string.daisy_desc),
            R.drawable.dog_three
        ),
        Puppy(
            stringResource(R.string.lola),
            Gender.FEMALE.value,
            stringResource(R.string.lola_desc),
            R.drawable.dog_four
        ),
        Puppy(
            stringResource(R.string.max),
            Gender.MALE.value,
            stringResource(R.string.max_desc),
            R.drawable.dog_five
        ),
        Puppy(
            stringResource(R.string.buddy),
            Gender.MALE.value,
            stringResource(R.string.buddy_desc),
            R.drawable.dog_six
        ),
        Puppy(
            stringResource(R.string.charlie),
            Gender.MALE.value,
            stringResource(R.string.charlie_desc),
            R.drawable.dog_seven
        ),
        Puppy(
            stringResource(R.string.rocky),
            Gender.MALE.value,
            stringResource(R.string.rocky_desc),
            R.drawable.dog_eight
        ),
    )

    LazyColumn() {
        items(puppyList) { puppy ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { gotoDetail(puppy,context) }
            ) {
                Image(
                    painter = painterResource(id = puppy.puppyImage),
                    contentDescription = null,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .clip(shape = RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )
                Column(Modifier.padding(10.dp)) {
                    Text(
                        text = puppy.name!!,
                        style = typography.h6
                    )
                    Text(
                        text = puppy.gender!!,
                        style = typography.body1
                    )
                }
            }

            Divider(color = Color.LightGray, thickness = 1.dp)
        }


    }


}

fun gotoDetail(puppy: Puppy,context: Context) {
    val detailIntent = Intent(context, DetailActivity::class.java)
    val bundle = Bundle()
    bundle.putParcelable("Detail", puppy)
    detailIntent.putExtras(bundle)
    context.startActivity(detailIntent)

}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
