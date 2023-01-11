from z3 import *


def solution():
    
    t = Real('t')
    s = Real('s')
    c = Real('c')

    C1 = (t + s + c == 10)
    C2 = (c + s - t == 6)
    C3 = (c + t -s == 4)
    C = And(C1, C2, C3)
    
    s = Solver()
    s.add(C)
    
    isSat = s.check()
    
    if(isSat == sat):
        return s.model()
    else:
        return -1
    
print(solution())



