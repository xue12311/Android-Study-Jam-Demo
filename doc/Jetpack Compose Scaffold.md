---
title:  Jetpack Compose学习  Scaffold
date: 2021-5-26 16:26:25
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Scaffold

### Scaffold 基本使用

```kotlin

@Composable
fun ScaffoldDemo() {
    val materialBlue700 = Color(0xFF1976D2)
    //设置抽屉的打开状态
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        //顶部导航栏
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "标题")
                },
                backgroundColor = materialBlue700,
            )
        },
        //悬浮按钮
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    if (scaffoldState.drawerState.isClosed) {
                        scaffoldState.drawerState.open()
                    } else {
                        scaffoldState.drawerState.close()
                    }
                }
            }) {
                Text("X")
            }
        },
        //悬浮按钮的位置
        floatingActionButtonPosition = FabPosition.End,
        //抽屉内容
        drawerContent = {
            Text(text = "drawerContent")
        },
        //内容
        content = {
            Text("BodyContent")
        },
        //底部导航栏
        bottomBar = {
            BottomAppBar(
                backgroundColor = materialBlue700
            ) {
                Text(text = "BottomAppBar")
            }
        }
    )
}


```