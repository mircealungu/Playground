# A simple solution for the 

class cell(object):
	def __init__(self, x, y, content):
		self.x = x
		self.y = y
		self.content = content

	def __str__(self):
		return '[%d, %d = %s ]' % (self.x, self.y, self.content)


class board(object):
	def __init__(self, dimensions):
		self.dimensions = dimensions
		self.cells = set()

		# Add border cells
		for i in range(0,dimensions+2):
			self.cells.add(cell(0,i,"*"))
			self.cells.add(cell(dimensions+1,i,"*"))
			self.cells.add(cell(i,0,"*"))
			self.cells.add(cell(i,dimensions+1,"*"))

	def add(self, cell):
		self.cells.add(cell)


	def show(self):
		n = self.dimensions+2
		for r in range(0,n):
			for c in range (0,n):
				c = self.cell_at_coords(c,r)
				if c:
					print c.content, 
				else:
					print " ",
			print " "


	def cell_at_coords(self, x, y):
		"""
		return None if there is no cell at those coords
		"""

		try: 
			return (filter(lambda cell: cell.x == x and cell.y == y, self.cells))[0]
		except:
			return None


	def find_empty_cell(self):
		"""
			Useful for getting the cell that is moveable 
		"""
		try: 
			return (filter(lambda cell: cell.content == ".", self.cells))[0]
		except:
			return None



	def neighbours_for(self, cell):
		n = [(-1,0),(1,0),(0,-1),(0,1)]
		return [self.cell_at_coords(cell.x - nx[0], cell.y - nx[1]) for nx in n]

	def possible_moves(self):
		empty = board.find_empty_cell()
		return [x for x in board.neighbours_for(empty) if x.content != "*"]

	def solution(self):
		for x in range (1,self.dimensions+1):
			for y in range (1,self.dimensions+1):
				c = board.cell_at_coords(x, y).content
				if (not c == str(x+(y-1)*self.dimensions)) and (not c == "."):
					return False
		return True


# #####

board = board(2)

# Board cells

board.add(cell(1,1,"1"))
board.add(cell(2,1,"2"))
board.add(cell(1,2,"."))
board.add(cell(2,2,"3"))

board.show()


# print find_empty_cell(board)

print "neighbours:"
for n in board.neighbours_for(board.find_empty_cell()):
	print n

print "possible moves:"
for n in board.possible_moves():
	print n


print board.solution()




def solve (board, history): 
	if solution(board):
		print "found a solution"
		print_board(board)



