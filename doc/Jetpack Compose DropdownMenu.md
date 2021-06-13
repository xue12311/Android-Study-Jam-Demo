---
title:  Jetpack Compose学习  DropdownMenu
date: 2021-5-25 11:21:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- DropdownMenu 下拉菜单

### DropdownMenu 下拉菜单 基本使用

```kotlin

@Composable
fun DropdownSample() {
    val isExpanded = remember {
        mutableStateOf(false)
    }
    val list = listOf("A", "B", "C", "D", "E", "F", "G")
    val disabledValue = "B"
    var selectedIndex = remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Text(
            text = list[selectedIndex.value],
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .padding(10.dp)
                .clickable {
                    isExpanded.value = true
                }
                .background(
                    Color.Black
                ),
            color = Color.White
        )
        DropdownMenu(
            expanded = isExpanded.value,
            onDismissRequest = { isExpanded.value = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
        ) {
            list.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex.value = index
                    isExpanded.value = false
                }
                ) {
                    val disaledText = if (disabledValue == s) {
                        " (Disabled)"
                    } else {
                        ""
                    }
                    Text(text = "${s}${disaledText}")
                }
            }
        }
    }
}

```