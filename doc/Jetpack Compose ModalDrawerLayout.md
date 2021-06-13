---
title:  Jetpack Compose学习  ModalDrawerLayout
date: 2021-5-26 14:20:55
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- ModalDrawerLayout 导航抽屉

### ModalDrawerLayout 导航抽屉 基本使用

```kotlin

@Composable
fun ModalDrawerLayoutSample() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column {
                Text(text = "Text in Drawer")
                Button(onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        content = {
            Column {
                Text(text = "Text in Bodycontext")
                Button(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                    Text(text = "Open Drawer")
                }
            }
        }
    )
}

```