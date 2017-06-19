#!/bin/sh

service call SurfaceFlinger 1015 i32 1 f $1 f 0 f 0 f 0 f 0 f $2 f 0 f 0 f 0 f 0 f $3 f 0 f 0 f 0 f 0 f 1 > /dev/null
