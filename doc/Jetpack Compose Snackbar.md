---
title:  Jetpack Compose学习  Snackbar
date: 2021-5-26 15:28:38
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Snackbar 

### Snackbar 基本使用

```kotlin

@Composable
fun SnackbarDemo() {
    Column {
        val snackbarVisibilityState = remember {
            mutableStateOf(false)
        }
        Button(
            onClick = { snackbarVisibilityState.value = !snackbarVisibilityState.value }
        ) {
            if (snackbarVisibilityState.value) {
                Text("隐藏 Snackbar")
            } else {
                Text("显示 Snackbar")
            }
        }
        if (snackbarVisibilityState.value) {
            Snackbar(
                action = {
                    Button(onClick = {}) {
                        Text(text = "MyAction")
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text("This is a snackbar!")
            }
        }
    }
}

```