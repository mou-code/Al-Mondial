using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
namespace Al_Mondial
{
    public partial class Player : Form
    {
        Controller controller;
        public Player()
        {
            controller = new Controller();  
            InitializeComponent();
            DataTable dt = controller.SelectAllPlayers();
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "Name";
            comboBox1.ValueMember = "Player_id";
            comboBox1.Refresh();
        }

        private void Player_Load(object sender, EventArgs e)
        {

        }

        private void AddPlayer_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length == 0)
            {
                MessageBox.Show("Please Enter An Id");
                return;
            }
            int Player_id = Int32.Parse(textBox1.Text);
            string name = textBox2.Text;
            if (name.Length == 0)
            {
                MessageBox.Show("Please Enter A Name");
                return;
            }
            string pos = textBox3.Text;
            if (pos.Length == 0)
            {
                MessageBox.Show("Please Enter A Pos");
                return;
            }
         
                int age = (int)numericUpDown1.Value;
                int Team_id = (int)numericUpDown2.Value;
                int res = controller.InsertPlayer(Player_id, name, 0, 0, age, pos, Team_id);
                if (res == 0)
                    MessageBox.Show("Error");
                else
                    MessageBox.Show("InsertedSuccessfully");
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            DataTable dt = controller.SelectPlayerGoals(Int32.Parse(comboBox1.SelectedValue.ToString()));
            int gs = (int)dt.Rows[0][0];
            int res=controller.UpdatePlayerGoals(Int32.Parse(comboBox1.SelectedValue.ToString()),gs+1);
            if (res == 0)
                MessageBox.Show("Error");
            else
                MessageBox.Show("UpdatedSuccessfully");


         
        }

        private void button3_Click(object sender, EventArgs e)
        {
            DataTable dt = controller.SelectPlayerCleanSheets(Int32.Parse(comboBox1.SelectedValue.ToString()));
            int cs = (int)dt.Rows[0][0];
            int res = controller.UpdatePlayerCleanSheets(Int32.Parse(comboBox1.SelectedValue.ToString()), cs + 1);
            if (res == 0)
                MessageBox.Show("Error");
            else
                MessageBox.Show("UpdatedSuccessfully");







        }
    }
}
