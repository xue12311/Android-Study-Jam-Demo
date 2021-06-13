---
title:  Jetpack Compose学习  Switch
date: 2021-5-26 15:05:22
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Switch 开关

### Switch 开关 基本使用

```kotlin

@Composable
fun SwitchSample() {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Switch(checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
        }
    )
}

```