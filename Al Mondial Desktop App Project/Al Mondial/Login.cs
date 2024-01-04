using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
//using System.Drawing;

namespace Al_Mondial
{
   
    public partial class Login : Form
    {
        Controller controller;
        public Login()
        {
            InitializeComponent();
            controller = new Controller();  
           
        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_Click(object sender, EventArgs e)
        {
            LogInNameTextbox.BackColor = Color.FromArgb(86, 4, 44);
        }

        private void textBox2_Click(object sender, EventArgs e)
        {
            PasswordTexbox.BackColor = Color.FromArgb(86, 4, 44);
        }

        private void pictureBox3_MouseDown(object sender, MouseEventArgs e)
        {
            if (PasswordTexbox.UseSystemPasswordChar == false)
            {
                PasswordTexbox.UseSystemPasswordChar = true;
            }
            else
                PasswordTexbox.UseSystemPasswordChar = false;
        }

        private void LoginButton_Click(object sender, EventArgs e)
        {
            if(LogInNameTextbox.Text.Length==0)
            {
                MessageBox.Show("Enter A Name");
                return;
            }
            if(PasswordTexbox.Text.Length==0)
            {
                MessageBox.Show("Enter A Pass");
                return;
            }
            
            string user_n = LogInNameTextbox.Text.ToString();
            string pass = PasswordTexbox.Text.ToString();
            DataTable users = controller.SelectUsernamespass();
            string us = "",pa=" ";
            bool flag = false;
            foreach (DataRow dr2 in users.Rows)
            {
                us = dr2["Username"].ToString();
                pa= dr2["Pass"].ToString();
                if (user_n == us && pass == pa)
                {
                    flag = true;
                    break;
                }
            }
            if (flag == false)
            {
                MessageBox.Show("No Such User");
                return;
            }
            DataTable dt =controller.SelectUserType(user_n);
            int type = (int)dt.Rows[0][0];
            
            ALMondial_System form = new ALMondial_System(user_n, type);
            this.Hide();
            form.ShowDialog();
            this.Close();

        }
    }
}
