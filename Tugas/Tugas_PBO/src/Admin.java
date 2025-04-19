class Admin extends User{
    private String username;
    private String password;

    public Admin(String nama, String nim){
        super(nama, nim);
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public Boolean login(User users){
        return users.getNama().equals(this.username) && users.getNim().equals(this.password);
    }

    @Override
    public void displayInfo(User users){
        System.out.println("\nAnda login sebagai :");
        System.out.println("Nama : " + users.getNama());
//        System.out.println("NIM : " + this.nim);
    }
}
