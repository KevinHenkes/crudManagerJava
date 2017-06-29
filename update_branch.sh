#!/bin/sh
regex='^[0-9]{3}$'
echo "Update <branch> module (merge from dev)"
echo "Enter the name of actual branch where you work (the 3-digits number of the task) :"
read branch
if [[ $branch =~ $regex ]];
then
	git fetch &&
	git pull origin dev &&
	git checkout $branch &&
	git merge dev
else
	echo "Bad argument supply."
fi
