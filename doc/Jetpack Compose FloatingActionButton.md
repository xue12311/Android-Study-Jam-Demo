---
title:  Jetpack Compose学习  FloatingActionButton
date: 2021-5-26 14:00:43
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- FloatingActionButton 悬浮按钮

### FloatingActionButton 悬浮按钮 基本使用

```kotlin

@Composable
fun FloatingActionButtonSample() {
    Column(Modifier.padding(10.dp)) {
        FloatingActionButton(
            onClick = { },
        ) {
            Text(text = "悬浮按钮")
        }
        Spacer(modifier = Modifier.height(30.dp))
        ExtendedFloatingActionButton(
            text = {
                Text(text = "悬浮按钮")
            },
            icon = {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "喜爱")
            },
            onClick = {

            },
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
        )
    }
}

```