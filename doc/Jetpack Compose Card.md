---
title:  Jetpack Compose学习  Card
date: 2021-5-25 11:16:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Card

### Card 卡片 简单使用

```kotlin
   @Composable
    fun CardDemo() {
        Card(
            modifier = Modifier.fillMaxWidth() ,
            backgroundColor = Color.White,
            elevation = 10.dp,
        ) {
            Text(text = "This is a Card Demo",Modifier.padding(10.dp))
        }
    }
```
```kotlin

    @Composable
    fun ComposableSample() {
        Card(
            modifier = Modifier
                .size(200.dp)
                .padding(10.dp),
            //形状 圆角矩形
            shape = RoundedCornerShape(8.dp),
            //背景颜色
            backgroundColor = Color.White,
            //内容的颜色
            contentColor = Color.Black,
            //边框
            border = BorderStroke(0.5.dp, Color.Gray),
            //阴影
            elevation = 10.dp
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.mipmap.icon_header),
                    contentDescription = "图片描述",
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }

```
```kotlin
 @Composable
    fun CardDemo() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                // 外边距
                .padding(15.dp)
                .clickable(
                    // 设置点击波纹效果，注意如果 CardDemo() 函数不在 ExamplesTheme() {} 下调用
                    // 将无法显示波纹效果
                    onClick = {
                        Log.d("Clickable", " clicked.")
                    }),
            backgroundColor = Color.White,
            // 设置阴影
            elevation = 10.dp,
        )
        {
            Column(
                // 内边距
                Modifier.padding(15.dp)
            ) {
                Text(buildAnnotatedString {
                    append("welcome to ")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF4552B8),
                            fontWeight = FontWeight.W900,
                        )
                    ) {
                        append("Jetpack Compose Playground")
                    }
                })
                Text(buildAnnotatedString {
                    append("Now you are in the ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W900,
                        )
                    ) {
                        append("Card")
                    }
                    append(" section")
                })
            }
        }
    }
```