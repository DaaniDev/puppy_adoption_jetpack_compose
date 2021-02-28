package com.daanidev.puppyadoptionlist.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daanidev.puppyadoptionlist.StaggeredVerticalGrid
import com.daanidev.puppyadoptionlist.ui.detail.DetailActivity
import com.daanidev.puppyadoptionlist.ui.main.model.PuppyModel
import com.daanidev.puppyadoptionlist.ui.main.repository.DogRepository

class MainActivity : AppCompatActivity() {

    var dogRepository=DogRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val columnWidth = 220

            Surface(color = Color.White,
            modifier = Modifier.fillMaxHeight()) {

                Column {

                    LazyColumn {
                        item {
                            StaggeredVerticalGrid(
                                maxColumnWidth = columnWidth.dp,
                                modifier = Modifier.padding(4.dp)
                            ) {

                                dogRepository.getPuppyList().forEach {
                                    Card(it)
                                    {

                                        startDetailActivity(it)
                                    }

                                }


                            }
                        }
                    }
                }
            }
        }
    }

    private fun startDetailActivity(puppy: PuppyModel){

        val inn = Intent(this,DetailActivity::class.java)

      inn.putExtra("puppy_obj",puppy)
        startActivity(inn)
    }
}

@Composable
fun Card(
    puppy:PuppyModel,
    modifier: Modifier = Modifier,
    singlePuppy: (PuppyModel)->Unit
) {

    Surface(
        modifier = modifier
            .padding(4.dp),
        color= Color.White,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column (modifier = Modifier
            .height(220.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        )
        {
            val image: Painter = painterResource(id = puppy.image)
     Image(painter = image, contentDescription = puppy.bread,
    modifier= Modifier
        .fillMaxWidth()
        .height(130.dp),
     contentScale = ContentScale.FillBounds
     )
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 5.dp),
            verticalArrangement = Arrangement.Center) {
                Text(text = "Name: "+puppy.name,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Breed: "+puppy.bread,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }


            Button(onClick = {
            singlePuppy.invoke(puppy)
            },modifier = Modifier.height(40.dp)) {
                Text(
                    text = "View Detail",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()

                )
            }
        }
    }
}