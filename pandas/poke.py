import pandas as pd

# inspired from: https://www.youtube.com/watch?v=vmEHCJofslg

df = pd.read_csv("pokemon_data.csv")

# prints
print(df.head(5))

# Read headers
print(df.columns)

# Read given columns
print(df["Name"][0:10])
print(df.Name[10:20])
print(df[["Name", "Attack"]][20:30])

# Reading rows
print(df.iloc[0:4])

# Iterate over all rows
# for index, row in df.iterrows():
#     print(index, row["Name"])

# Reading cells
# loc[row_label, column_label]
# iloc[row_position, column_position]

print(df.loc[5, "Name"])
print(df.iloc[5, 1])

print(df.loc[5, ["Name", "Type 1"]])

# Filtering data
# https://towardsdatascience.com/how-to-use-loc-and-iloc-for-selecting-data-in-pandas-bd09cb4c3d79
print(df.loc[df.Attack > 150, :])

print(df.loc[df["Type 1"] == "Dragon", :])

print(df.loc[(df["Type 1"] == "Dragon") & (df.Attack > 150), :])

print(df.groupby(["Type 1"]).count())
print(df.groupby(["Type 1"]).mean())
