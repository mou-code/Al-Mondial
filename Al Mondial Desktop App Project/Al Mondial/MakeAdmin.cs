using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Al_Mondial
{
    public partial class MakeAdmin : Form
    {
        Controller controller;
        public MakeAdmin(string s)
        {
            InitializeComponent();
            controller = new Controller();
            DataTable dt = controller.SelectAllUsers();
            foreach (DataRow dr in dt.Rows)
            {
                if (s == dr["Username"].ToString())
                    dr.Delete();
            }
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "Username";
            
            comboBox1.Refresh();
        }

        private void button12_Click(object sender, EventArgs e)
        {
          
            int res = controller.MakeAdmin(comboBox1.Text.ToString());
            if (res == 0)
                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("Made it Admin");



        }
    }
}
