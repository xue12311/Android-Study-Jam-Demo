---
title:  Jetpack Compose学习  Swipeable
date: 2021-5-27 14:13:11
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- Swipeable 滑动

### Swipeable 滑动 基本使用

```kotlin


@Composable
fun ComposableSample() {
    var blockSize = 48.dp
    var blockSizePx = with(LocalDensity.current) { blockSize.toPx() }
    var swipeableState = rememberSwipeableState(initialValue = Status.CLOSE)
    var anchors = mapOf(
        0f to Status.CLOSE,
        blockSizePx to Status.OPEN
    )
    Box(
        modifier = Modifier
            .size(
                height = blockSize,
                width = blockSize * 2
            )
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                //滑动
                .swipeable(
                    state = swipeableState,
                    //锚点，可以通过锚点设置在不同状态时所应该对应的偏移量信息
                    anchors = anchors,
                    //常用作定制不同锚点间吸附效果的临界阈值
                    //常用有 FixedThreshold(Dp) 和 FractionalThreshold(Float)等
                    thresholds = { from, to ->
                        if (from == Status.CLOSE) {
                            FractionalThreshold(0.3f)
                        } else {
                            FractionalThreshold(0.5f)
                        }
                    },
                    //手势方向，被修饰组件的手势方向只能是水平或垂直
                    orientation = Orientation.Horizontal,
                )
                //移动
                .offset {
                    //整体移动
                    IntOffset(swipeableState.offset.value.toInt(), 0)
                }
                .size(blockSize)
                .background(Color.DarkGray)
        )
    }
}

enum class Status {
    CLOSE, OPEN
}


```