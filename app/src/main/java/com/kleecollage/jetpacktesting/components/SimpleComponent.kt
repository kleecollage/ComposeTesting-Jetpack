package com.kleecollage.jetpacktesting.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SimpleComponent() {
    var name by rememberSaveable { mutableStateOf("John Doe") }

    Column(Modifier.fillMaxSize()) {
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.testTag("textFieldName")
        )

        Text(
            text = "Te llamas $name",
            modifier = Modifier.testTag("textGreeting")
        )

        Image(Icons.Default.AccountCircle, contentDescription = "Image")
        Image(Icons.Default.ThumbUp, contentDescription = "Icon")

    }
}