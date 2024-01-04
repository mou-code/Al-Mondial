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
    public partial class Team : Form
    {
        Controller controller;
        public Team()
        {
            InitializeComponent();
            controller = new Controller();
            DataTable dt = controller.SelectAllGroups();
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "Group_id";
            comboBox1.Refresh();
            DataTable dt2 = controller.SelectAllSponsers();
            comboBox2.DataSource = dt2;
            comboBox2.DisplayMember = "Sponser_Name";
            comboBox2.Refresh();

        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {




        }

        private void button10_Click(object sender, EventArgs e)
        {
            if(textBox2.Text.Length==0)
            {
                MessageBox.Show("Enter An Id ");
                return;
            }
     
            if(textBox1.Text.Length==0)
            {
                MessageBox.Show("Enter A Name");
                return;

            }

            int res = controller.InsertTeam(Int32.Parse(textBox2.Text.ToString()), textBox1.Text, Int32.Parse(comboBox1.Text.ToString()), comboBox2.Text);
            if(res==0)
            
                MessageBox.Show("Error Occured");
                else
                    MessageBox.Show("Added Successfully");
            



        }
    }
}
