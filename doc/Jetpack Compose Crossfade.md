---
title:  Jetpack Compose学习  Crossfade
date: 2021-5-25 11:20:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Crossfade

### Crossfade 动画 淡入淡出

```kotlin

enum class MyColors(val color: Color) {
    Red(Color.Red),
    Green(Color.Green),
    Blue(Color.Blue),
}

//淡入淡出 动画
@Composable
fun CrossfadeDemo() {
    var currentColor = remember {
        mutableStateOf(MyColors.Red)
    }
    Column {
        Row {
            MyColors.values().forEach { myColors ->
                Button(
                    onClick = { currentColor.value = myColors },
                    Modifier.weight(1f, true)
                        .height(48.dp)
                        .background(myColors.color),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = myColors.color
                    )
                ) {
                    Text(myColors.name, color = Color.White)
                }
            }
        }
        //淡入淡出 切换动画
        Crossfade(
            targetState = currentColor,
            animationSpec = tween(3000)
        ) { selectedColor ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = selectedColor.value.color)
            )
        }
    }
}

```
