---
title:  Jetpack Compose学习  CircularProgressIndicator
date: 2021-5-25 11:18:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- CircularProgressIndicator 圆形进度条

### CircularProgressIndicator 圆形进度条 基本使用

```kotlin

    @Composable
fun CircularProgressIndicatorSample() {
    var progress = remember {
        mutableStateOf(0.0f)
    }
    val animatedProgress = animateFloatAsState(
        targetValue = progress.value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "进度 不确定 的 圆形 进度条")
        Spacer(modifier = Modifier.height(30.dp))
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "圆形进度条 进度通过 点击按钮 添加")
        Spacer(modifier = Modifier.height(30.dp))
        CircularProgressIndicator(progress = animatedProgress)
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedButton(onClick = {
            if (progress.value < 1f) {
                progress.value += 0.1f
            }
        }) {
            Text(text = "添加进度")
        }
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedButton(onClick = {
            if (progress.value > 0f) {
                progress.value -= 0.1f
            }
        }) {
            Text(text = "降低进度")
        }
    }
}


```