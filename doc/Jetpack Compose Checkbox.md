---
title:  Jetpack Compose学习  Checkbox
date: 2021-5-25 11:17:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Checkbox 复选框

### Checkbox 复选框 基本使用

```kotlin

@Composable
fun CheckBoxDemo() {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
        }
    )
}

```