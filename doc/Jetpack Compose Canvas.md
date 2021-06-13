---
title:  Jetpack Compose学习  Canvas
date: 2021-5-25 11:15:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Canvas 图形 

### Canvas 图形 基本属性

```kotlin

//绘制 线
    @Composable
    fun CanvasDrawLineDemo() {
        //画布
        Canvas(
            //充满整个屏幕
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            //绘制 线
            drawLine(
                start = Offset(x = canvasWidth, y = 0f),
                end = Offset(x = 0f, y = canvasHeight),
                color = Color.Red
            )
        }
    }

  //绘制 圆
    @Composable
    fun CanvasDrawCircleDemo() {
        //画布
        Canvas(
            //充满整个屏幕
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            //绘制 圆
            drawCircle(
                color = Color.Red,
                //圆心  画布中心点
                center = Offset(
                    x = canvasWidth / 2,
                    y = canvasHeight / 2
                ),
                //半径 : 画布最小边 的 1/4
                radius = size.minDimension / 4
            )
        }
    }

//绘制 弧
@Composable
fun CanvasDrawArcDemo() {
    //画布
    Canvas(
        //充满整个屏幕
        modifier = Modifier.fillMaxSize()
    ) {
        //绘制 弧
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 60f,
            useCenter = true,
            size = Size(300f, 300f),
            topLeft = Offset(60f, 60f)
        )
    }
}

 //绘制 矩形
    @Composable
    fun CanvasDrawRectDemo() {
        //画布
        Canvas(
            //充满整个屏幕
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasQuadrantSize = size / 2f

            //绘制 矩形
            drawRect(
                color = Color.Red,
                size = canvasQuadrantSize
            )
        }
    }


    //绘制 矩形
    @Composable
    fun CanvasInsetDrawRectDemo() {
        //画布
        Canvas(
            //充满整个屏幕
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasQuadrantSize = size / 2f
            //更改绘图边界
            inset(150f, 30f) {
                //绘制 矩形
                drawRect(
                    color = Color.Red,
                    size = canvasQuadrantSize
                )
            }
        }
    }
    
      //绘制 矩形
    @Composable
    fun CanvasDrawRectTopLeftDemo() {
        //画布
        Canvas(
            //充满整个屏幕
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val canvasSize = size
            //绘制 矩形
            drawRect(
                color = Color.Red,
                topLeft = Offset(x = canvasWidth / 3f, y = canvasHeight / 3f),
                size = canvasSize / 3f
            )
        }
    }
    
     //绘制 矩形
    @Composable
    fun CanvasRotateDrawRectDemo() {
        //画布
        Canvas(
            //充满整个屏幕
            modifier = Modifier.fillMaxSize()
        ) {
            //旋转 45 度
            rotate(degrees = 45f) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val canvasSize = size
                //绘制 矩形
                drawRect(
                    color = Color.Red,
                    topLeft = Offset(x = canvasWidth / 3f, y = canvasHeight / 3f),
                    size = canvasSize / 3f
                )
            }
        }
    }
    
    //绘制 矩形
    @Composable
    fun CanvasTransformDrawRectDemo() {
        //画布
        Canvas(
            //充满整个屏幕
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val canvasSize = size
            //多种转换
            withTransform({
                //平移
                translate(left = canvasWidth / 5f)
                //旋转 45 度
                rotate(degrees = 45f)
            }) {
                //绘制 矩形
                drawRect(
                    color = Color.Red,
                    topLeft = Offset(x = canvasWidth / 3f, y = canvasHeight / 3f),
                    size = canvasSize / 3f
                )

            }
        }
    }
```