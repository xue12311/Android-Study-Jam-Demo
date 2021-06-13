---
title:  Jetpack Compose学习  LazyRow
date: 2021-5-25 11:24:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- LazyRow 延迟 水平 布局

### LazyRow 延迟 水平 布局 简单使用

```kotlin

 @Composable
    fun LazyRowDemo() {
        val list = listOf("A", "B", "C", "D") + ((0..20).map { it.toString() })
        LazyRow(Modifier.fillMaxHeight()) {
            items(
                key = { list.get(it) },
                count = list.size,
                itemContent = { item ->
                    val content = list.get(item)
                    Log.d("COMPOSE", "This get rendered ${content}")
                    when (content) {
                        "A" -> {
                            Text(text = content, style = TextStyle(fontSize = 80.sp))
                        }
                        "B" -> {
                            Button(onClick = {}) {
                                Text(text = content, style = TextStyle(fontSize = 80.sp))
                            }
                        }
                        "C" -> {
                        }
                        "D" -> {
                            Text(text = content)
                        }
                        else -> {
                            Text(text = content, style = TextStyle(fontSize = 80.sp))
                        }
                    }
                }
            )
        }
    }

```
