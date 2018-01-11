<h1>Housemanagement</h1>
Spring Boot mini-project Housemanagement v2.0. 
Used Spring Boot, Spring security, Thymeleaf, SQLite DB, Bootstrap.

1. You can authorize in system as user1, user2, user3 or admin. Users ('user1', 'user2', 'user3') can enter your consumed volume of water and this number inserts in housemanagementdb (SQLite-based DB). 
2. Users can view table of own records in DB, including username, volume and time of creation the records.
3. Admin ('admin') can view table of users consumed volume with username and time of creation the records.
4. File housemanagementdb.db consists this tables:
metrics (consits users volume metrics), users (consists username and password for access to Housemanagement), user_roles (consists users roles for Spring security)
5. URL of Housemanagement v2.0 webservice: http://localhost:8080
6. Usernames and Passwords for access to Housemanagement:
<table>    
    <tr>
        <th>Username</th>
        <th>Password</th>        
    </tr>    
        <tr>
            <td>user1</td>
            <td>user1</td>            
        </tr>
        <tr>
            <td>user2</td>
            <td>user2</td>            
        </tr>
        <tr>
            <td>user3</td>
            <td>user3</td>            
        </tr>
        <tr>
            <td>admin</td>
            <td>admin</td>            
        </tr>
</table>

<b>Project will be evolved soon...</b>
