# Performance - Custom View

## Introduction

This goal of this project is to have you explore the profiling tools while improving the performance of one of your apps. One of the best showcases of these tools is with your view projects from last week.

## Instructions

For this project, you'll fork this repo, clone it to your computer, and then place a copy of your volume control knob app from last week inside of the cloned repo. Commit and push the result. Then begin using the tools taught this week to improve the performance of the app. After that is done, you'll use these tools on another one of your apps to improve its performance as well, good candidates for this would be the AsyncTasks app and the Contacts app from sprint 6. While working on these apps, be sure to make note of the improvements that you made in the readme down below as well as the combined execution of the `onTouchEvent` and `onDraw` methods before and after updates. There are always improvements to be made in an app.

Remember, to attain the desired smooth 60fps frame rate, you'll only have 16 milliseconds to draw each frame. In addition to that, you'll want to make that time as short as possible in order to prevent unforeseen circumstances from adding "jank" to your app. You'll also want to ensure your CPU and Memory usage is low.

## Record Improvements Here
### Volume Control Knob

| Description                              |                 Location                        | Time Before | Time After |
| ---------------------------------------- | :---------------------------------------------: | ----------: | ---------- |
| Removed variable                         | VolumeControlKnob.java, onTouchEvent, line 96   |     4  ms   |   4 ms     |
| Removed variable                         | VolumeControlKnob.java, onTouchEvent, line 112  |             |            |
| Removed variable                         | VolumeControlKnob.java, onTouchEvent, line 115  |             |            |
| Removed method call                      | VolumeControlKnob.java, onTouchEvent, line 122  |             |            |
| String.format to concat                  | VolumeControlKnob.java, onTouchEvent, line 131  |             |            |

#### Combined `onTouchEvent` and `onDraw` Execution Times
Before Improvements:
~9ms

After Improvements:
~6ms
