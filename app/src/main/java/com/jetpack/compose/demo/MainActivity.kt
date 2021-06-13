package com.jetpack.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainView()
        }
    }

    @Preview
    @Composable
    fun mainView() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "TextField演示") },
                    elevation = 8.dp,
                )
            }) {
            Column(Modifier.padding(10.dp)) {
                val text = remember {
                    mutableStateOf(TextFieldValue(""))
                }
                val numberText = remember {
                    mutableStateOf(TextFieldValue(""))
                }
                TextField(
                    value = text.value,
                    onValueChange = { newValue -> text.value = newValue },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(text = "label")
                    },
                    placeholder = {
                        Text("placeholder")
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = text.value,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(text = "PassWord")
                    },
                    placeholder = {
                        Text(text = "123456")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = { newValue -> text.value = newValue },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = text.value,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = {
                        Text(text = "Email Address")
                    },
                    placeholder = {
                        Text(text = "Your Email")
                    },
                    onValueChange = { newValue -> text.value = newValue }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = text.value,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = {
                        Text(text = "Email Address")
                    },
                    placeholder = {
                        Text(text = "Your Email")
                    },
                    onValueChange = { newValue -> text.value = newValue }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = numberText.value,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = {
                        Text(text = "Phone Number")
                    },
                    placeholder = {
                        Text(text = "Please enter the phone number")
                    },
                    onValueChange = { newValue -> numberText.value = newValue }
                )

                Spacer(modifier = Modifier.height(10.dp))

                val password = remember {
                    mutableStateOf(TextFieldValue(""))
                }
                val passwordVisualTransformation = remember {
                    mutableStateOf<VisualTransformation>(
                        PasswordVisualTransformation()
                    )
                }
                val passwordInteractionState = remember {
                    MutableInteractionSource()
                }
                OutlinedTextField(
                    value = password.value,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.VpnKey,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = if (passwordVisualTransformation.value != VisualTransformation.None) {
                                Icons.Default.Visibility
                            } else {
                                Icons.Default.VisibilityOff
                            },
                            modifier = Modifier.clickable {
                                passwordVisualTransformation.value =
                                    if (passwordVisualTransformation.value != VisualTransformation.None) {
                                        VisualTransformation.None
                                    } else {
                                        PasswordVisualTransformation()
                                    }
                            },
                            contentDescription = null,
                        )
                    },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    label = {
                        Text(text = "PassWord")
                    },
                    placeholder = {
                        Text(text = "Please enter the password")
                    },
                    onValueChange = { newValue ->
                        password.value = newValue
                    },
                    interactionSource = passwordInteractionState,
                    visualTransformation = passwordVisualTransformation.value,
                )
            }
        }
    }
}