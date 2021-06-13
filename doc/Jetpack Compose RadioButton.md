---
title:  Jetpack Compose学习  RadioButton
date: 2021-5-26 14:36:21
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- RadioButton 单选按钮

### RadioButton 单选按钮 基本使用

```kotlin

@Composable
fun RadioButtonSample() {
    val radioOptions = listOf<String>("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(radioOptions[1])
    }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = text == selectedOption,
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (selectedOption == text),
                    onClick = {
                        onOptionSelected(text)
                    }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(16.dp)
                )

            }
        }
    }
}

```