---
title:  Jetpack Compose学习  Modifier
date: 2021-5-25 11:25:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Modifier

### padding 设置各个UI的padding

```kotlin

// 给上下左右全部设置成同一个值
Modifier.padding(10.dp)
// 分别为左（开始）、上（上）、右（结束）、下（下）设值
Modifier.padding(10.dp, 20.dp, 30.dp, 40.dp)
// 分别为左右（水平）和上下（垂直）设值
Modifier.padding(10.dp, 20.dp)
//PaddingValues 与 padding 不一样
// 给上下左右全部设置成同一个值
Modifier.padding(PaddingValues(10.dp))
// 分别为左右（水平）和上下（垂直）设值
Modifier.padding(PaddingValues(10.dp, 20.dp))
//分别为左（开始）、上（上）、右（结束）、下（下）设值
Modifier.padding(PaddingValues(10.dp, 20.dp, 30.dp, 40.dp))

```

### fillMaxHeight,fillMaxWidth,fillMaxSize 类似于match_parent,填充整个父layout

```kotlin

//填充整个父Layout
Modifier.fillMaxSize()
//填充整个父Layout的宽度
Modifier.fillMaxWidth()
//填充整个父Layout的高度
Modifier.fillMaxHeight()

```

### width,heigh,size 设置Content的宽度和高度

```kotlin

//设置宽度
Modifier.width(80.dp)
//设置高度
Modifier.height(80.dp)
//设置 宽度和高度
Modifier.size(100.dp)
//设置 宽度,高度
Modifier.size(100.dp, 100.dp)

```

### widthIn, heightIn, sizeIn 设置Content的宽度和高度的最大值和最小值

```kotlin

//设置 最小宽度 最大宽度
Modifier.widthIn(20.dp, 50.dp)
//设置 最小高度 最大高度
Modifier.heightIn(20.dp, 50.dp)
//设置 最小宽度,最小高度,最大宽度,最大高度
Modifier.sizeIn(20.dp, 20.dp, 50.dp, 50.dp)

```

### wrapContentHeight,wrapContentWidth,wrapContentSize,
```kotlin

// 高度 位于 顶部
Modifier.wrapContentHeight(Alignment.Top)
// 高度 位于 底部
Modifier.wrapContentHeight(Alignment.Bottom)
// 高度 位于 垂直居中
Modifier.wrapContentHeight(Alignment.CenterVertically)
// 高度 位于 水平居中
Modifier.wrapContentHeight(Alignment.CenterHorizontally)
// 宽度 位于 开始（左）
Modifier.wrapContentWidth(Alignment.Start)
// 宽度 位于 结束（右）
Modifier.wrapContentWidth(Alignment.End)
// 宽度 位于 水平居中
Modifier.wrapContentWidth(Alignment.CenterHorizontally)
// 宽度 位于 垂直居中
Modifier.wrapContentWidth(Alignment.CenterVertically)
//位置 位于 顶部 开始（左）
Modifier.wrapContentSize(Alignment.TopStart)
//位置 位于 顶部 结束（右）
Modifier.wrapContentSize(Alignment.TopEnd)
//位置 位于 顶部 水平居中
Modifier.wrapContentSize(Alignment.TopCenter)
//位置 位于 底部 开始（左）
Modifier.wrapContentSize(Alignment.BottomStart)
//位置 位于 底部 结束（右）
Modifier.wrapContentSize(Alignment.BottomEnd)
//位置 位于 底部 水平居中
Modifier.wrapContentSize(Alignment.BottomCenter)
//位置 位于 垂直居中 开始（左）
Modifier.wrapContentSize(Alignment.CenterStart)
//位置 位于 垂直居中 结束（右）
Modifier.wrapContentSize(Alignment.CenterEnd)

```