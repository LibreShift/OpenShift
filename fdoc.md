Commands grabbed from libflux.so, hex edited to log the commands instead of running them.

Modified libflux.so not included in this repo for obvious reasons

# RESET:
```
service call SurfaceFlinger 1015 i32 0
```

# ADJUST:
```
service call SurfaceFlinger 1015 i32 1 i32 $1 i32 $2 i32 $3 i32 0 i32 $4 i32 $5 i32 $6 i32 0 i32 $7 i32 $8 i32 $9 i32 0 i32 0 i32 0 i32 0 i32 $10
```

These are my best guesses.

1: Red (?). Normal seems to be around 1060000000

2: Not entirely sure. Normal seems to be around -1200000000

3: Blue. Normal seems to be around -1200000000

4: Cyan. Normal seems to be around 1065000000

5: Green. Normal seems to be around 1065000000

6: Yellow. Normal seems to be around -1500000000

7: Red. Normal seems to be around 1000000000

8: Contrast. Normal seems to be around -1200000000

9: Hue. Normal seems to be around 1065000000

10: Gamma. Normal seems to be around 1065000000

I would greatly appreciate any contributions, if you figure out how a value works please create a PR or an issue.
