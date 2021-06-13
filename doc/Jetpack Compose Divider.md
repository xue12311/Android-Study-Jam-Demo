---
title:  Jetpack Compose学习  Divider
date: 2021-5-27 15:29:42
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Divider 分割线

### Divider 分割线 基本使用

```kotlin

@Composable
fun ComposableSample() {
    Column(Modifier.fillMaxWidth()) {
        Text("Hello Word Hello Word Hello Word")
        //分割线
        Divider(
            //颜色
            color = Color.Blue,
            //线的高度
            thickness = 1.dp,
            //距离开始的间距
            startIndent = 10.dp
        )
        Text("Hello Word")
        //分割线
        Divider(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 10.dp, end = 10.dp),
            //颜色
            color = Color.Green,
        )
        Text("Hello Word Hello Word")
        Text("Hello Word Hello Word Hello Word")
    }
}

```