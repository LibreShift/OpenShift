Commands grabbed from libflux.so, hex edited to log the commands instead of running them.

Modified libflux.so not included in this repo for obvious reasons

# RESET:
```
service call SurfaceFlinger 1015 i32 0
```

Thanks to @raatmarien for finding the docs for this api!

# ADJUST:
```
service call SurfaceFlinger 1015 i32 1
f $r f 0 f 0 f 0
f 0 f $g f 0 f 0
f 0 f 0 f $b f 0
f 0 f 0 f 0 f 1
```
