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
    public partial class Coach : Form
    {
        Controller controller;
        public Coach()
        {
            InitializeComponent();
            controller=new Controller();
            DataTable dt = controller.SelectAllTeams();
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "Name";
            comboBox1.ValueMember = "id";
            comboBox1.Refresh();

        }

        private void button11_Click(object sender, EventArgs e)
        {
            if(textBox1.Text.Length==0)
            {
                MessageBox.Show("Enter A Name");
                return;
            }
            if (textBox2.Text.Length == 0)
            {
                MessageBox.Show("Enter An Age");
                return;
            }
            int age = 0;
            try
            {
                age = Int32.Parse(textBox2.Text.ToString());
            }
            catch
            {
                MessageBox.Show("error In Age");
                return;
            }
            if (textBox3.Text.Length == 0)
            {
                MessageBox.Show("Enter A Nationality");
                return;
            }
            int res = controller.InsertCoach(Int32.Parse(comboBox1.SelectedValue.ToString()), textBox1.Text,age , textBox3.Text);
            if (res == 0)

                MessageBox.Show("Error Occured");

            else
                MessageBox.Show("Added Successfully");



        }
    }
}
