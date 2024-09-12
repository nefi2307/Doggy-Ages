package com.example.doggyages

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doggyages.ui.theme.DoggyAgesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DoggyAgesTheme {
                Surface (
                color = MaterialTheme.colorScheme.background
                ) {
                    imageDoggy()
                }
                }
            }
        }
    }


@Composable
fun buttonAge()
{

}


// Titulo
@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(
        text = "Doggy Ages ",
        modifier = modifier
            .padding(
                start = 12.dp,
                top = 12.dp,
                end = 12.dp,
                bottom = 12.dp
            )
    )
}

@Composable
fun ButtonAge(modifier: Modifier = Modifier)
{
    //Button(onClick = { /* Do something! */ })  { Text("¡Convert you age!") }
    Button(
        onClick = { /* Do something! */ },
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
        modifier = Modifier
            .padding(
                start = 12.dp,
                top = 20.dp
            )
    ) {
        Icon(
            Icons.Filled.Face,
            contentDescription = "Button to convert ages",
            modifier = Modifier.
            size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("¡Convert your age!")
    }
}

// TextField
@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "loveIcon") },
      //  trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = {
            text = it
        },
        label = { Text(text = "Enter you age, human.") },
        placeholder = { Text(text = "Age") },
    )
}

// Preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DoggyAgesTheme {
        imageDoggy()
    }
}

// Función para mostrar imagen y llamar a las funciones de titulo y textField
@Composable
fun imageDoggy(modifier:Modifier = Modifier)
{
    Column (
        horizontalAlignment =Alignment.CenterHorizontally,
            modifier = Modifier
            .fillMaxSize()
    ){
        val imagen = painterResource(id = R.drawable.image)
        Image(painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
        Title()
        TextFieldWithIcons()
        ButtonAge()


    }

}