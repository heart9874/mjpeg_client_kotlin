# Mjpeg-View-Android-Kotlin
Android Mjpeg Video streaming in Kotlin as well as saving images in frames.

Some of the features of this library is

- Able to stream video in an android application.
- Requires only http url to make connection.
- Ability to save video frames in images in the directory Mjpeg.
- Can save the image in background(Foreground service integration(updated)).

## Installation

Add Jitpack to your project build.gralde file
      
      allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
}

Then add this dependency to your app build.gradle file.

      dependencies {
	       implementation 'com.github.heart9874:mjpeg_client_kotlin:1.0'
	}

## Usage
1. Add a view to XML layout:
````xml
 <com.dipesh.mjpegviewer.MjpegView
        android:id="@+id/mjpegid"
        android:layout_width="wrap_content"
        android:layout_height="473dp"
        android:onClick="startService"/>
````
Remove startService if don't want utilize integrate foreground service

2. Specify mjpeg source and start streaming
````Kotlin
private var view: MjpegView? = null
view = findViewById(R.id.mjpegid)
view!!.isAdjustHeight = true
view!!.mode1 = MjpegView.MODE_FIT_WIDTH
view!!.setUrl("<<Your HTTP URL>>")
view!!.isRecycleBitmap1 = true
view!!.startStream()

//when user leaves application
viewer!!.stopStream();
````
3. Start Foreground Service
````
 val serviceIntent = Intent(this, ForegroundService::class.java)
 startService(serviceIntent)
````
4. Stop Foreground Service
````
val stopIntent = Intent(this, ForegroundService::class.java)
stopService(stopIntent)
````
## PS
Please give permission to storage for saving images.
## License

Copyright 2021 Dipesh Web Developer

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
         
      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.




