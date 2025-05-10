EXECUTION
Host file updation
$gedit /etc/ansible/hosts
To view the files in ansible
cd /etc/ansible
ls
hosts ansible.cfg roles
roles
ansible-galaxy init apache
ls
tree apache
$ansible main.yml
Run the playbook
$ansible-playbook wintest.yml