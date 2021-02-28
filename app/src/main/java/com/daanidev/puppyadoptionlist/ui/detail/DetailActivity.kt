package com.daanidev.puppyadoptionlist.ui.detail

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daanidev.puppyadoptionlist.ui.main.model.PuppyModel

class DetailActivity:AppCompatActivity() {


  var puppyModel:PuppyModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        puppyModel=intent.getParcelableExtra("puppy_obj")

        setContent {

            Surface(color = Color.White,
                modifier = Modifier.fillMaxHeight()) {

                Column {
puppyDetail(puppyModel!!)

                }
            }
        }

     supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

@Composable
fun puppyDetail(
    puppy:PuppyModel,
    modifier: Modifier = Modifier,

) {

        Surface(
            modifier = modifier
                .padding(4.dp),
            color= Color.White,
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column (modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 10.dp),
                verticalArrangement = Arrangement.Top
            )
            {
                val image: Painter = painterResource(id = puppy.image)
                Image(painter = image, contentDescription = puppy.bread,
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                    verticalArrangement = Arrangement.Center) {
                    Text(text = "Name: "+puppy.name,
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h6
                    )
                    Text(text = "Breed: "+puppy.bread,
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body1
                    )
                    Text(text = "Gender: "+puppy.gender,
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2
                    )
                    Text(text = "Age: "+puppy.age,
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2
                    )
                    Text(text = "Length: "+puppy.length+" Feet",
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2
                    )
                    Text(text = "Color: "+puppy.color,
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2
                    )
                }

            }
    }


}
