

# For line changes between top commit of any branch and unstaged of current branch
##### files changed, insertions, deletions 
git diff --shortstat <branch_a>.. HEAD^

# For line changes between top commit any branch and top commit of current branch
##### files changed, insertions, deletions 
git diff --shortstat <branch_a>...
