---
title:  Jetpack Compose学习  BottomNavigation
date: 2021-5-27 10:35:17
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- BottomNavigation 底部导航栏

### BottomNavigation  底部导航栏 基本使用

```kotlin

@Composable
fun ComposableSample() {
    var selectedItem by remember {
        mutableStateOf(0)
    }
    val list_name = listOf("主页", "喜爱", "设置")
    val list_icon = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Settings)
    Scaffold(
        topBar = {
            //顶部导航栏
            TopAppBar(
                title = {
                    Text(text = list_name.get(selectedItem))
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                list_name.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = {
                            Icon(
                                imageVector = list_icon[index],
                                contentDescription = null,
                            )
                        }, label = {
                            Text(text = item)
                        })
                }
            }
        }
    ) {
        Text(
            text = list_name[selectedItem],
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}


```