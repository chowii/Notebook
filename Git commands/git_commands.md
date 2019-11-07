

# For line changes between any branch top commint and unstaged of current branch
# files changed, insertions, deletions 
git diff --shortstat <branch_a>.. HEAD^

# For line changes between any branch top commint and current branch's top commit
# files changed, insertions, deletions 
git diff --shortstat <branch_a>...