---
title:  Jetpack Compose学习  Surface
date: 2021-5-26 17:45:26
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Surface

### 用 Surface 实现 Card 的效果

```kotlin

    @Composable
    fun ComposableSample() {
        Surface(
            //设置形状
            shape = RoundedCornerShape(10.dp),
            // 设置阴影
            elevation = 10.dp,
            modifier = Modifier
                .fillMaxWidth()
                // 外边距
                .padding(15.dp)
                .clickable { }
        ) {
            Column(
                // 内边距
                Modifier.padding(15.dp)
            ) {
                Text(
                    buildAnnotatedString {
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
                Text(
                    buildAnnotatedString {
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
