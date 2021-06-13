---
title:  Jetpack Compose学习  Slider
date: 2021-5-26 15:37:22
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Slider 拖动条

### Slider 拖动条 基本使用

```kotlin

    @Composable
fun SliderDemo() {
    Column(Modifier.padding(10.dp)) {
        val sliderPosition = remember {
            mutableStateOf(0f)
        }
        Slider(value = sliderPosition.value, onValueChange = {
            sliderPosition.value = it
        })
        Spacer(modifier = Modifier.height(5.dp))
        Text("当前进度: ${sliderPosition.value.toString()}")
    }
}

```


```kotlin

 @Composable
    fun ComposableSample() {
        val sliderPosition = remember {
            mutableStateOf(0f)
        }
        Slider(
            value = sliderPosition.value,
            colors = SliderDefaults.colors(
                //圆圈的颜色
                thumbColor = Color.White,
                //滑条颜色 (注 : 滑条默认颜色:inactiveTrackColor  默认是 与 activeTrackColor 一样 设置了 0.24f 透明度)
                activeTrackColor = Color(0xFF0079D3)
            ),
            onValueChange = {
                sliderPosition.value = it
            }
        )
    }

```
