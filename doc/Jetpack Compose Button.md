---
title:  Jetpack Compose学习  Button IconButton
date: 2021-5-25 11:14:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- 按钮 Button , IconButton

### Button 按钮 基本使用

```kotlin

@Composable
fun ButtonSample() {
    Button(
        onClick = {
            Log.d("ButtonSample", "按钮被点击")
        },
        modifier = Modifier.padding(10.dp),
        colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Blue)
    ) {
        Text(text = "按钮", color = Color.White)
    }
}

```

```kotlin

    @Composable
    fun ComposableSample() {
        Button(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "喜爱",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            //间隔
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "喜爱")
        }
    }

```


### IconButton 图标按钮 基本使用

```kotlin

@Composable
fun ComposableSample() {
    Row {
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Search, null)
        }

        IconButton(onClick = { }) {
            Icon(Icons.Filled.ArrowBack, null)
        }

        IconButton(onClick = { }) {
            Icon(Icons.Filled.Done, null)
        }
        val isSelected = remember {
            mutableStateOf(false)
        }
        //取消水波纹
        IconButtonNoIndication(onClick = {
            isSelected.value = !isSelected.value
        }) {
            Icon(
                Icons.Filled.Home,
                null,
                tint = if (isSelected.value) {
                    Color.Red
                } else {
                    Color.Gray
                }
            )
        }
    }
}


    /**
     * 去掉水波纹
     */
    @Composable
    fun IconButtonNoIndication(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = modifier
                .clickable(
                    onClick = onClick,
                    enabled = enabled,
                    role = Role.Button,
                    interactionSource = interactionSource,
                    //取消水波纹
                    indication = null
                )
                .then(Modifier.size(48.dp)),
            contentAlignment = Alignment.Center
        ) { content() }
    }
```