---
title:  Jetpack Compose学习  TopAppBar
date: 2021-5-26 15:05:57
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- TopAppBar 标题

### TopAppBar 标题 基本使用

```kotlin

@Composable
fun TopAppBarSample() {
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text("标题内容")
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "返回")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "分享")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "设置")
                }
            }
        )
        Text(text = "Hello World")
    }
}

```