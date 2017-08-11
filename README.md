# gradle-mali-plugin
Gradle plugin for the Mali Texture Compression Tool

## How to use

Add the following buildscript configuration to the top of your build.gradle

```gradle
buildscript {
    repositories {
        mavenLocal()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath group: 'org.mini2Dx', name: 'mali', version: '1.0.0'
    }
}
```

Then add the plugin configuration to your project.

```gradle
project(":projectName") {
   apply plugin: "org.mini2Dx.mali"
   
   ........

   mali {
      inputPaths = ["../preprocess/backgrounds"]
      outputPaths = ["../assets/backgrounds"]
      maliBinFolderPath = "/path/to/mali/bin/directory/"
      etc {
         enabled = true
         ktx = true
         mipmaps = true
      }
   }
}
```

The plugin will add the following tasks to your project.

| Task  | Description |
| ------------- | ------------- | 
| compressTextures  | Compresses textures using Mali per the configuration |

## Advanced Configuration

The following example shows all options in use.

```gradle
project(":projectName") {
   apply plugin: "org.mini2Dx.mali"
   
   ........

   mali {
      inputPaths = ["../preprocess/backgrounds"]
      outputPaths = ["../assets/backgrounds"]
      
      //Specify paths for different platforms for cross-platform builds
      maliWindowsBinFolderPath = "C:\\path\\to\\windows\\mali\\bin\\directory"
      maliMacBinFolderPath = "/path/to/mac/mali/bin/directory/"
      maliLinuxBinFolderPath = "/path/to/linux/mali/bin/directory/"
      
      etc {
         //Enable/disable ETC compression
         enabled = false
         //Set to false for slower more thorough optimal quality search
         fastCompression = true
         //Set to false to use non-perceptual (highest PSNR)
         perceptual = true
         //Set to true to use ETC2 compression.
         //ETC1 is most compatible, ETC2 has highest quality.
         etc2 = false
         //The compressed format.
         //Can be- R, R_signed, RG, RG_signed, RGB, RGBA1, RGBA8 or RGBA.
         //Defaults to RGB.
         format = "RGB"
         //Set to true to enable mipmaps
         mipmaps = false
         //Set to true to ouput KTX format instead of PKM
         ktx = false
         //Set to true for verbose output
         verbose = false
         //Set to true to output progress
         progress = false
      }
      astc {
         //Enable/disable ASTC compression
         enabled = false
         //Set the speed/quality tradeoff.
         //Can be veryfast, fast, medium, thorough or exhaustive.
         //Defaults to medium.
         compressionSpeed = "medium"
         //Sets the bits per texel
         bitsPerTexel = "8.0"
         //Set to true to treat textures as RGBA
         alphablend = false
         //Set to true to treat textures as HDR
         hdr = false
      }
   }
}
```