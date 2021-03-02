package com.example.androiddevchallenge.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class DetailActivity : AppCompatActivity() {
    lateinit var puppy: Puppy
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        puppy = intent.extras?.getParcelable<Puppy>("Detail")!!
        setContent {
            MyTheme() {
                PuppyDetail()
            }
        }
    }

    @Composable
    fun PuppyDetail() {
        Surface(color = MaterialTheme.colors.background) {
            initDetail()
        }
    }

    @Composable
    fun initDetail() {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = puppy.puppyImage),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = puppy.name!!,
                style = typography.h6
            )
            Text(
                text = puppy.gender!!,
                style = typography.body1
            )
            Text(
                text = puppy.desc!!,
                style = typography.body2
            )
        }
    }
}