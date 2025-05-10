Step 1: Install Ansible
On your control machine (master):

bash
Copy code
sudo apt update        # for Ubuntu/Debian
sudo apt install ansible
Check version:

bash
Copy code
ansible --version
Step 2: Update the host file
Edit the Ansible inventory file:

bash
Copy code
sudo gedit /etc/ansible/hosts
Add your managed hosts (replace with your actual IPs):

csharp
Copy code
[webservers]
192.168.8.130
192.168.8.140
Save and close.

Step 3: Create the playbook
Create a file called simple_webapp.yml:

bash
Copy code
sudo gedit simple_webapp.yml
Paste this playbook:

yaml
Copy code
---
- name: Simple Web Application Setup
  hosts: webservers
  become: yes

  tasks:
    - name: Install Apache (Debian/Ubuntu)
      apt:
        name: apache2
        state: present
      when: ansible_os_family == "Debian"

    - name: Install Apache (RedHat/CentOS)
      yum:
        name: httpd
        state: present
      when: ansible_os_family == "RedHat"

    - name: Start and enable Apache service
      service:
        name: "{{ 'httpd' if ansible_os_family == 'RedHat' else 'apache2' }}"
        state: started
        enabled: yes

    - name: Deploy sample index.html page
      copy:
        content: "<html><body><h1>Welcome to My Simple Web App!</h1></body></html>"
        dest: /var/www/html/index.html
        mode: '0644'
Save and close.

Step 4: Run the playbook
Run it with:

bash
Copy code
ansible-playbook -i /etc/ansible/hosts simple_webapp.yml