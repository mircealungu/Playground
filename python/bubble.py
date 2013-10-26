a = [10,3,9,4]

swap = True
while swap:
	for i in range(1,len(a)-1):
		swap = False
		if (a[i]>a[i+1]):
			a[i],a[i+1]=a[i+1],a[i]
			swap = True

print a
