# PlayWrightTester

This is a testing code, which fails to return the eh correctly. If the waiting state is changed to LoadState.NETWORKIDLE, it works correctly. 
The default state 'LOAD' for Page.navigate method seems not enough for querySelector call in this case. I suspect if LOAD state is the end of complete element loading.

