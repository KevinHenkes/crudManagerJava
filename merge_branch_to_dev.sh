#!/bin/sh
regex='^[0-9]{3}$'
echo "Merge from <branch> to dev module"
echo "Enter the name of actual branch where you work (the 3-digits number of the task) :"
read branch
if [[ $branch =~ $regex ]];
then
	echo "Confirm you want merge branch $branch : (Y/N)"
	read choice
	if [ $choice == "Y" ];
	then
		git fetch &&
		git pull origin dev &&
		git checkout dev &&
		git merge $branch
	else
		echo "You choose N (No) or bad argument"
		exit
	fi
else
	echo "Bad argument supply."
fi
