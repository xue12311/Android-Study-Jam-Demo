---
title:  Jetpack Compose学习  Shape 
date: 2021-5-25 11:26:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Shape 形状

```kotlin

   @Composable
    fun ShapeDemo() {
        Column(
            Modifier
                .fillMaxWidth() 
        ) {
            //RectangleShape 矩形形状
            ExampleBox(shape = RectangleShape)
            //CircleShape 圆圈形状
            ExampleBox(shape = CircleShape)
            //RoundedCornerShape 圆角形状
            ExampleBox(shape = RoundedCornerShape(10.dp))
            //CutCornerShape 切角形状
            ExampleBox(shape = CutCornerShape(10.dp))
        }
    }

    @Composable
    fun ExampleBox(shape: Shape) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .wrapContentSize(Alignment.Center)
        )
        {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape)
                    .background(Color.Blue)
            )
        }
    }

```